class ResourcesController < ApplicationController

  def index
    @resources = Resource.all
    @school = School.find(6)

    @requests = @school.requests.map {|request| request.resources}.flatten

  end

  def new
    @resource = Resource.find(params[:id])
  end

  def show
  end

  def create
  end

end
