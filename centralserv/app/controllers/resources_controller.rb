class ResourcesController < ApplicationController

  def index
    @resources = Resource.all
  end

  def new
    @resource = Resource.find(params[:id])
  end

  def show
  end

end
