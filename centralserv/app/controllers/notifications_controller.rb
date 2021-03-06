class NotificationsController < ApplicationController

  def index
    @school = School.find(1)
  end

  def show
    @notification = Notification.find(params[:id])
  end

  def new
    @notification = Notification.new
    @school = School.find(1)
  end

  def create
    @notification = Notification.create(notification_params)
    redirect_to school_path(1), :notice => "Notification created successfully!"
  end

  private

  def notification_params
    params.require(:notification).permit(:title, :content, :school_id)
  end

end
